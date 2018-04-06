import me.evo.eimage.Rand
import me.evo.eimage.Rand.randDNA
import me.evo.eimage.Setting
import me.evo.eimage.look.L1Score
import me.evo.eimage.plan.BestSelector
import me.evo.eimage.verb.GAMutate
import me.evo.eimage.verb.HCMutate
import me.ui.preview.PImageMonitor
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File
import java.lang.Thread.sleep
import javax.imageio.ImageIO

fun splitImage(image: BufferedImage, nRow: Int, nCol: Int) = ArrayList<ArrayList<BufferedImage>>().apply {
    for (i in 0 until nRow) {
        add(ArrayList<BufferedImage>().apply {
                for (j in 0 until nCol) {
                    add(BufferedImage(image.width / nCol, image.height / nRow, BufferedImage.TYPE_4BYTE_ABGR).apply {
                        val painter: Graphics2D = createGraphics()
                        painter.drawImage(image, 0, 0, width, height, width * j, height * i, width * j + width, height * i + height, null)
                    })
                }
        })
    }
}

fun mergeImages(images: ArrayList<ArrayList<BufferedImage>>): BufferedImage {
    val one = images[0][0]
    val nRow = images.size
    val nCol = images[0].size
    return BufferedImage(one.width * nCol + nCol - 1, one.height * nRow + nRow - 1, BufferedImage.TYPE_4BYTE_ABGR).apply {
        val painter = createGraphics()
        for (i in 0 until nRow) {
            for (j in 0 until nCol) {
                val img = images[i][j]
                val w = img.width
                val h = img.height
                painter.drawImage(img, w * j + j, h * i + i, w * j + j + w, h * i + i + h, 0, 0, w, h, null)
            }
        }
    }
}




fun main(vararg args: String) {
    val monitor = PImageMonitor()
    monitor.turnOn(600, 400)

    val targetImage = ImageIO.read(
            File ("./img/200_balloon.png")
    )

    val imgs = splitImage(targetImage, 4, 4)
    val img = mergeImages(imgs)
    monitor.show(img)

     monitor.holdOn()
}
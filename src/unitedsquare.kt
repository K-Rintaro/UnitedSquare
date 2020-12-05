import javafx.application.Application
import javafx.scene.Group
import javafx.scene.PerspectiveCamera
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color
import javafx.scene.paint.PhongMaterial
import javafx.scene.shape.Sphere
import javafx.stage.Stage
import javafx.scene.transform.Rotate



class HunHun : Application() {
    private var x = 0.0
    private var y = 0.0

    override fun start(primaryStage: Stage?) {
        primaryStage?.show()

        val theearth = Sphere(10.0)
        val earthpic = Image("earth.jpg")

        val material = PhongMaterial();
        material.diffuseMap = earthpic;
        theearth.material = material


        val group = Group(theearth)

        val scene = Scene(group, 640.0, 320.0, Color.BLACK)

        val rotateX = Rotate(0.0, Rotate.X_AXIS)
        val rotateY = Rotate(0.0, Rotate.Y_AXIS)
        group.transforms.addAll(rotateX, rotateY)

        scene.addEventHandler(MouseEvent.MOUSE_PRESSED) { e ->
            this.x = e.getSceneX()
            this.y = e.getSceneY()
        }

        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED) { e ->
            val nowX: Double = e.getSceneX()
            val nowY: Double = e.getSceneY()
            val dx = x - nowX
            val dy = y - nowY

            rotateX.angle = rotateX.angle - dy * 0.5
            rotateY.angle = rotateY.angle + dx * 0.5
            x = nowX
            y = nowY
        }

        val camera = PerspectiveCamera(true);
        camera.fieldOfView = 45.0
        camera.translateZ = -50.0
        scene.camera = camera

        primaryStage?.scene = scene
        primaryStage?.title = "United Square"
        primaryStage?.show()
    }


}

fun main(args: Array<String>) {
    Application.launch(HunHun::class.java, *args)
}

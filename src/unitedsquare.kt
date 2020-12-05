import javafx.application.Application
import javafx.scene.Group
import javafx.scene.PerspectiveCamera
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.paint.Color
import javafx.scene.paint.PhongMaterial
import javafx.scene.shape.Sphere
import javafx.stage.Stage

class HunHun : Application() {
    override fun start(primaryStage: Stage?) {
        primaryStage?.show()

        val theearth = Sphere(10.0)

        val camera = PerspectiveCamera(true);
        camera.fieldOfView = 45.0
        camera.translateX = 0.0
        camera.translateY = 0.0
        camera.translateZ = -50.0

        val earthpic = Image("earth.jpg")

        val material = PhongMaterial();
        material.diffuseMap = earthpic;
        theearth.material = material


        val group = Group(theearth)

        val scene = Scene(group, 640.0, 320.0, Color.BLACK)
        scene.camera = camera

        primaryStage?.scene = scene
        primaryStage?.title = "United Square"
        primaryStage?.show()
    }

}

fun main(args: Array<String>) {
    Application.launch(HunHun::class.java, *args)
}

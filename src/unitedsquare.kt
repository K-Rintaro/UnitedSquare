import javafx.application.Application
import javafx.scene.*
import javafx.scene.image.Image
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color
import javafx.scene.paint.PhongMaterial
import javafx.scene.shape.Sphere
import javafx.scene.text.Font
import javafx.scene.text.Text
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
        theearth.rotate = 23.4

        val syuumatsu = Text()
        syuumatsu.text = "23:58.40"
        syuumatsu.font = Font.font("Helvetica", 8.0)
        syuumatsu.fill = Color.WHITE
        syuumatsu.layoutX = -13.0
        syuumatsu.layoutY = -12.0

        val group = Group(syuumatsu,theearth)

        val point = PointLight(Color.RED);
        point.translateX = 240.0
        point.translateY = 0.0
        point.translateZ = -250.0
        group.children.add(point);

        val light1 = AmbientLight(Color.rgb(100, 100, 100, 0.5));
        group.children.add(light1);

        val scene = Scene(group, 640.0, 320.0, Color.BLACK)

        val rotateX = Rotate(0.0, Rotate.X_AXIS)
        val rotateY = Rotate(0.0, Rotate.Y_AXIS)
        theearth.transforms.addAll(rotateX, rotateY)

        theearth.addEventHandler(MouseEvent.MOUSE_PRESSED) { e ->
            this.x = e.getSceneX()
            this.y = e.getSceneY()
        }

        theearth.addEventHandler(MouseEvent.MOUSE_DRAGGED) { e ->
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

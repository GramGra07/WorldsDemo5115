//import
package org.firstinspires.ftc.teamcode

import com.qualcomm.hardware.rev.RevBlinkinLedDriver
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.teamcode.extensions.BlinkExtensions.initLights
import org.firstinspires.ftc.teamcode.extensions.BlinkExtensions.setPatternCo


open class HardwareConfig() {

    constructor(opMode: LinearOpMode, ahwMap: HardwareMap) : this() {
        myOpMode = opMode
        this.initRobot(ahwMap)
    }

    companion object {
        lateinit var lights: RevBlinkinLedDriver
        private lateinit var myOpMode: LinearOpMode
    }

    private fun initRobot(
        ahwMap: HardwareMap,
    ) {
        lights = initLights(ahwMap, "blinkin")
        lights.setPatternCo(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_RAINBOW_PALETTE)
    }

    fun doBulk() {
        if (myOpMode.gamepad1.cross) {
            lights.setPatternCo(RevBlinkinLedDriver.BlinkinPattern.ORANGE)
        } else if (myOpMode.gamepad1.circle) {
            lights.setPatternCo(RevBlinkinLedDriver.BlinkinPattern.CONFETTI)
        }
    }
}


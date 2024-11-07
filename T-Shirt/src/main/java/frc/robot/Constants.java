package frc.robot;

public final class Constants {
    public static final class ControllerConstants {
        public static final int kDriverControllerPort = 0;

        public static final int LeftAxis = 1;
        public static final int RightAxis = 0;

        public static final double LeftAxisDeadZone = 0.1;
        public static final double RightAxisDeadZone = 0.1;

    }
        public static final class TankDriveConstants {

            public static final int LEFT_TOP_DRIVE = 0;
            public static final int LEFT_BOTTOM_DRIVE = 0;
            public static final int RIGHT_TOP_DRIVE = 0;
            public static final int RIGHT_BOTTOM_DRIVE = 0;

            public static final double  GEAR_RATIO = 1;
            public static final double  WHEEL_RADIUS = 1;
            public static final double  WHEEL_CIRCUMFERENCE = 2*Math.PI*WHEEL_RADIUS;

            public static final double MAX_ACCELERATION = 3;//METER/SECOND/SECOND
            public static final double MAX_VELOCITY = 1;//METER/SECOND
     
        }
    
}

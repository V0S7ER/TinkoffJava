package edu.hw2;

//import org.apache.logging.log4j.LogManager;

public class Task4 {
    private Task4() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement traceElement =
            new Throwable().getStackTrace()[0]; // первый элемент - это наша функция, т.к. мы в нее только вошли
        return new CallingInfo(traceElement.getClassName(), traceElement.getMethodName());
    }

//    public static void main(String[] args) {
//        CallingInfo info = callingInfo();
//        LogManager.getLogger().info(String.format("\nClass: %s\nMethod: %s", info.className(), info.methodName()));
//    }

    public record CallingInfo(String className, String methodName) {
    }
}

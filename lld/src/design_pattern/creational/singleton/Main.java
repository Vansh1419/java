package design_pattern.creational.singleton;


// Eagar loading
// Thread safe
//class JudgeAnalytics{
//    private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
//    private JudgeAnalytics(){}
//    public static JudgeAnalytics getInstance(){
//        return judgeAnalytics;
//    }
//}


// Lazy loading
//class JudgeAnalytics{
//    private static JudgeAnalytics judgeAnalytics;
//
//    private  JudgeAnalytics(){}
//    public static JudgeAnalytics getInstance(){
//        if(judgeAnalytics == null){
//            judgeAnalytics = new JudgeAnalytics();
//        }
//        return judgeAnalytics;
//    }
//}

//thread safety
//Synchronized keyword --> inefficient
//class JudgeAnalytics{
//    private static JudgeAnalytics judgeAnalytics;
//
//    private  JudgeAnalytics(){}
//    public static synchronized JudgeAnalytics getInstance(){
//        if(judgeAnalytics == null){
//            judgeAnalytics = new JudgeAnalytics();
//        }
//        return judgeAnalytics;
//    }
//}

//Double check locking
//class JudgeAnalytics{
//    private static volatile JudgeAnalytics judgeAnalytics;
//
//    private  JudgeAnalytics(){}
//    public static JudgeAnalytics getInstance(){
//        if(judgeAnalytics == null){
//            synchronized (JudgeAnalytics.class){
//                if(judgeAnalytics == null){
//                    judgeAnalytics = new JudgeAnalytics();
//                }
//            }
//        }
//        return judgeAnalytics;
//    }
//}


//Bill Pugh Singleton (Best Practice for Lazy Loading)
class JudgeAnalytics{
    private static volatile JudgeAnalytics judgeAnalytics;

    private  JudgeAnalytics(){}

    private static class Holder{
        private static JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    }
    public static JudgeAnalytics getInstance(){
        return Holder.judgeAnalytics;
    }
}


public class Main {
    public static void main(String[] args) {
//        JudgeAnalytics judgeAnalytics = new JudgeAnalytics(); // This method won't work as there is no constructor available
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();
        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics2);
    }
}

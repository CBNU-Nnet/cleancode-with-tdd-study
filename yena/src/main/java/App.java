
import View.InsertView;
import View.OutputView;
import controller.UserController;


public class App {

        public static void main(String args[]){

                InsertView view = new InsertView();
                String names = view.insertName();
                Integer num= view.insertNum();
                OutputView.result(num, UserController.initialize(names));


            }


}


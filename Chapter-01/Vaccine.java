import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String vaccine = JOptionPane.showInputDialog("請輸入疫苗名稱(AZ,BNT,Moderna)：");
        vaccine = vaccine.toLowerCase();

        if(vaccine.equals("az")){
            JOptionPane.showMessageDialog(null,"AZ\n研發國：英國\n劑量：2\n");
        } else if (vaccine.equals("bnt")) {
            JOptionPane.showMessageDialog(null,"BNT\n研發國：德國\n劑量：2\n");
        } else if (vaccine.equals("moderna")) {
            JOptionPane.showMessageDialog(null,"Moderna\n研發國：美國\n劑量：2\n");
        } else{
            JOptionPane.showMessageDialog(null,"無法辨別輸入內容。");
        }
    }
}

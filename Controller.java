package sample;

import javafx.fxml.FXML;
import javafx.scene.SnapshotResult;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
           private TextField name;
    @FXML
    private TextField number;
    @FXML
    private TextArea qwe;
    Contact2 contact2=new Contact2();
    @FXML
    public void add()
    {   String sd=number.getText();
    if(sd.length()==12)
    {
        long p=Long. parseLong(sd);
        String nm=name.getText();
        contact2.insertLast(nm,p);
        name.clear();
        number.clear();
        qwe.setText("Successfully Added");
        System.out.println(nm);
        System.out.println(p);}
    else{
        qwe.setText("Please Enter 12 digit number");
    }

    }
    @FXML
    public void display()
    {   qwe.clear();
        Node current = contact2.first;
        String s="";
        qwe.setPrefRowCount(10);
        while (current != null) {
            s=current.displayNode();
            current = current.next;
            qwe.appendText("\n"+s);

        }

    }
    @FXML
    public void updatename()
    {  try{
        qwe.clear();
        String nm=(number.getText());
        String p=name.getText();
        if(!contact2.updateContactName(p,nm))
        {
            qwe.setText("Please Enter Valid name");
        }
        else
        {
            qwe.setText("Successfully Updated");
        }}
        catch (Exception e)
        {
            qwe.setText("Please Enter the names");
        }
    }
    @FXML
    public void updateContact()
    {   try{
        qwe.clear();
        long p=Long. parseLong(number.getText());
        String pp=name.getText();
        if(!contact2.updateContactPhone(pp,p))
        {
            qwe.setText("Please Enter valid Name To update contact");
        }
        else {
            qwe.setText("Successfully Updated");
        }}
        catch (Exception e)
        {
            qwe.setText("Please Enter the Value kin the given boxes");
        }
    }
    public void del()
    {try{
        qwe.clear();
        Node n=new Node();
        String p=name.getText();
        n=contact2.deleteContact(p);
        if(n==null)
            qwe.setText("Please Enter Valid Name");
        else{
        qwe.setText("Successfully Deleted\n");
        qwe.appendText("Deleted Name:"+n.name+"\n");
        qwe.appendText("Deleted Contact:"+n.contact);}}
        catch (Exception e){
        qwe.setText("Please Enter the name");
        }
    }


}

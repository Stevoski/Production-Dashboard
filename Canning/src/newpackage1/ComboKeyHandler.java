/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;

import java.awt.EventQueue;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Stevoski
 */
public class ComboKeyHandler extends KeyAdapter{
    private final JComboBox<String>jComboBox5;
    private final List<String>list =new ArrayList<>();
    private boolean shouldHide;
    public ComboKeyHandler(JComboBox<String> combo){
    super();
this.jComboBox5=combo;   
for(int i=0;i<jComboBox5.getModel().getSize(); i++){
  list.add(jComboBox5.getItemAt(1));
}
    }
    private static void setSuggestionModel(JComboBox<String>jComboBox5,ComboBoxModel<String>cml,String str) 
{
jComboBox5.setModel(cml);
jComboBox5.setSelectedIndex(-1);
((JTextField)jComboBox5.getEditor().getEditorComponent()).setText(str);

}
    private static ComboBoxModel<String>getSuggestionModel(List<String>list,String text)
    {
      DefaultComboBoxModel<String> m=new DefaultComboBoxModel(); 
      for(String s:list){
          if(s.toLowerCase().startsWith(text.toLowerCase()))
              m.addElement(s);
      }
      return m;
    }
    @Override public void keyTyped(final KeyEvent e){
      EventQueue.invokeLater(new Runnable(){
          @Override public void run(){
              String text= ((JTextField)e.getComponent()).getText();
          ComboBoxModel<String>m;
          if(text.isEmpty()){
              String[] array=list.toArray(new String[list.size()]);
             m=new DefaultComboBoxModel<String> (array);  
              setSuggestionModel(jComboBox5,m,"");
              jComboBox5.hidePopup();
          }
          else{
              m=getSuggestionModel(list,text);
          if(m.getSize()==0||shouldHide){
              jComboBox5.hidePopup();
          }
          else{
              setSuggestionModel(jComboBox5,m,text);
         jComboBox5.showPopup();
          }
          }
          }
          });
     
    }
    
}

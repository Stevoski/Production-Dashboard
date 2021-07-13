/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;

import javax.swing.tree.TreeNode;

/**
 *
 * @author Stevoski
 */
public class rootNodeTaskIt {
    private TreeNode root;
    
    private class TreeNode{
       private String data;
    private TreeNode left;
    private  TreeNode right;
    
    public TreeNode(String data){
        this.data=data;
    
    }
    } 
    public void createBinaryTree(){
        TreeNode first=new TreeNode("TaskIt");
        TreeNode second=new TreeNode("Request New Task");
        TreeNode third=new TreeNode("Request List");
        TreeNode fourth=new TreeNode("Reports");
        TreeNode fifth=new TreeNode("Per Factory Reports");
        TreeNode sixth=new TreeNode("Maintenance Reports");
        TreeNode seventh=new TreeNode("Requests");
   
        root= first;
        first.left=seventh;
        seventh.right= third;
        seventh.right=fourth;
          
        fourth.left=fifth;
        fourth.right=sixth;
         
     
}
}

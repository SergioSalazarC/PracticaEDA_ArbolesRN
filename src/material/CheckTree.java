package material;

import material.tree.binarytree.BinaryTree;

import java.util.LinkedList;


/**
 *
 * @author mayte
 * @param <E>
 */

public class CheckTree<E extends Comparable> {
    public CheckTree() {
    }

    /**
     * Receives a BinaryTree and returns true if the tree is a BinarySearchTree
     * @param tree     
     * @return      
    */
    public boolean isBinarySearchTree(BinaryTree<E> tree){
        LinkedList<Position<E>> lista = new LinkedList<>();
        lista.add(tree.root());
        boolean fin=true;
        while(!lista.isEmpty() && fin){
            Position<E> p = lista.remove();
            if(tree.hasLeft(p)){
                fin=p.getElement().compareTo(tree.left(p).getElement())>0;
                lista.add(tree.left(p));
            }
            if(tree.hasRight(p)){
                fin=p.getElement().compareTo(tree.right(p).getElement())<0;
                lista.add(tree.right(p));
            }
        }
        return fin;
    }

}



package material;

import material.Position;
import material.tree.binarysearchtree.BinarySearchTree;
import material.tree.binarytree.LinkedBinaryTree;


/**
 *
 * @author mayte
 */
public class ClosestInteger {
    public ClosestInteger() {
    }

    /**
     * Recives a BinarySearchTree and an integer i and returns the Position that contains the closest integer to i
     * @param tree     
     * @param i     
     * @return      
     */
    public Position<Integer> closest (BinarySearchTree<Integer> tree, int i){
        LinkedBinaryTree<Integer> arbol = tree.getBinTree();
        int betaprox= arbol.root().getElement();
        Position<Integer> mejoraprox=arbol.root();
        Position<Integer> p = arbol.root();
        while(true){
            if(Math.abs(i-betaprox)>Math.abs(i-p.getElement())){
                betaprox=p.getElement();
                mejoraprox=p;
            }
            if(i>p.getElement()){
                if(arbol.hasRight(p)){
                    p=arbol.right(p);
                }
                else{
                    break;
                }
            }
            else if(i<p.getElement()){
                if(arbol.hasLeft(p)){
                    p=arbol.left(p);
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }

        return mejoraprox;

    }
    
}

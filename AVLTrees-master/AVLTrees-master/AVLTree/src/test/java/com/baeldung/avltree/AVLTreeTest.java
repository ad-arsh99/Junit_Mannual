package com.baeldung.avltree;

import org.junit.Test;

import static org.junit.Assert.*;


public class AVLTreeTest {
    private AVLTree tree = new AVLTree();

    private void insert(Integer...integers) {
        for(Integer i:integers)
            tree.insert(i);
    }

    private boolean checkBalanceOfTree(AVLTree.Node current) {

        boolean balancedRight = true, balancedLeft = true;
        int leftHeight = 0, rightHeight = 0;

        if (current.right != null)
        {
            balancedRight = checkBalanceOfTree(current.right);
            rightHeight =current.right.height;
        }

        if (current.left != null) {
            balancedLeft = checkBalanceOfTree(current.left);
            leftHeight = current.left.height;
        }

        return balancedLeft && balancedRight && Math.abs(leftHeight - rightHeight) < 2;
    }

    private boolean checkOrderingOfTree(AVLTree.Node current) {
        if(current.left != null) {
            if(current.left.key > current.key)
                return false;
            else
                return checkOrderingOfTree(current.left);
        } else  if(current.right != null) {
            if(current.right.key < current.key)
                return false;
            else
                return checkOrderingOfTree(current.right);
        }

        return true;
    }

    private AVLTree.Node findMin(AVLTree.Node t){

        if( t == null )
            return t;

        while( t.left != null )
            t = t.left;
        return t;
    }

    @Test
    public void testFindMin() {
        insert(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88,55,37,12,17);

        assertEquals(findMin(tree.getRoot()).key, 12);
        assertNotNull(tree.find(16));

        System.out.println(tree.height());
        System.out.println(tree.getRoot());
        System.out.println(tree.getRoot());
    }

    @Test
    public void testRemove() {
        insert(16,24,36,19,44,28,61,74,83,64,52,65,86,93,88,55,37,12,17);



        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));

        tree.delete(88);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(88));

        tree.delete(19);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(19));

        tree.delete(16);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(16));

        tree.delete(28);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(28));

        tree.delete(24);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(24));

        tree.delete(36);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(36));

        tree.delete(83);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(83));

        tree.delete(52);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(52));

        tree.delete(93);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(93));

        tree.delete(86);
        assertTrue(checkBalanceOfTree(tree.getRoot()));
        assertTrue(checkOrderingOfTree(tree.getRoot()));
        assertNull(tree.find(86));

        System.out.println(tree.height());
        System.out.println(tree.getRoot());
        System.out.println(tree.getRoot());
    }
}
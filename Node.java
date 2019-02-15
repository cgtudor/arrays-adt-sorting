/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.adt;

/**
 *
 * @author crist
 */
public class Node {
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
    Node()
    {
        data = 0;
        next = null;
    }
}

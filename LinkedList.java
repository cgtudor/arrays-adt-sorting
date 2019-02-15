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
public class LinkedList {
    Node head;
    int size;
    LinkedList()
    {
        head = null;
        size = 0;
    }
    LinkedList(Node head)
    {
        this.head = head;
        size = 1;
    }
    LinkedList(int[] array, int size)
    {
        this.size = size;
        this.addFirst(array[0]);
        for(int i = 1; i < size; i++)
            this.addLast(array[i]);
    }
    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast(int data)
    {
        Node newNode = new Node(data);
        Node c;
        for(c = head; c.next != null; c = c.next)
        {
        }
        c.next = newNode;
        size++;
    }
    public void addAt(int position, int data)
    {
        Node c;
        Node newNode = new Node(data);
        int i = 0;
        for(c = head; c.next != null; c = c.next)
        {
            i++;
            if(i+1 == position)
            {
                newNode.next = c.next;
                c.next = newNode;
                break;
            }
        }
        size++;
    }
    public int getAt(int position)
    {
        Node c;
        int i = 0;
        for(c = head; c.next != null; c = c.next)
        {
            i++;
            if(i == position)
            {
                return c.data;
            }
        }
        return -1;
    }
    public void print()
    {
        for(Node c = head; c != null; c = c.next)
            System.out.print(c.data+" ");
    }
}

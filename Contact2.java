package sample;

class Node {
    public long contact;
    public String name;
    public Node next;
    public Node previous;

    // display name and phone of a contact
    public String displayNode() {
        return ("{ " + name + " } " + ": " + "{ " + contact + " } ");
    }
}
public class Contact2 {

    public Node first; // to point first Node in the list
    public Node last; // to point last Node in the list

    // contact constructor
    public Contact2() {
        this.first = null; // assign null value
        this.last = null; // assign null value
    }

    // to check if linked list is empty
    public boolean isEmpty() {
        return (first == null);
    }

    // inserting a contact
    public void insertLast(String name, long contact) {
        Node newNode = new Node();
        newNode.name = name;
        newNode.contact = contact;

        if (isEmpty()) {
            first = newNode;
            last = first;
        } else {
            Node temp = first;
            boolean isShorter = false;
            do {
                if (newNode.name.compareTo(temp.name) < 0) {
                    isShorter = true;
                    break;
                }
                if (temp.next != null)
                    temp = temp.next;
            } while (temp.next != null);
//			last.next = newNode;
//			newNode.previous = last;
            if (newNode.name.compareTo(temp.name) < 0) {
                isShorter = true;
            }
            if (isShorter) {
//			newNode.next = temp.next;
//			temp.next.previous = newNode;
//			temp.next = newNode;
//			newNode.previous = temp;
                if (temp.previous != null)
                    temp.previous.next = newNode;
                else
                    first = newNode;
                newNode.next = temp;
                newNode.previous = temp.previous;
                temp.previous = newNode;
            } else {
                last.next = newNode;
                newNode.previous = last;
                last = newNode;
            }
        }
    }

    // for deleting a contact
    public Node deleteContact(String name) {
        Node current = first;
        while (!current.name.equals(name)) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;

        }
        return current;
    }

    // to update a contact's name
    public boolean updateContactName(String key, String updateName) {
        Node current = first;
        while (!current.name.equals(key)) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        current.name = updateName;
        return true;
    }

    // to update a contact's phone
    public boolean updateContactPhone(String key, long newContact) {
//        System.out.println(first.name + "   " + first.contact);
        Node current = first;
        while (!current.name.equals(key)) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        current.contact = newContact;
        return true;
    }

    // display the linked list
    // to view all contacts in the order added
    public String displayForward() {
        Node current = first;
        String s="";
        while (current != null) {
            s=s+current.displayNode()+"\n";
            current = current.next;
        }
        return s;
    }

}


import java.util.*;

public class Hospital {
    Head head = new Head();

    class Node {
        String data;
        int age;
        long mobileNo;
        Node next;

        public Node(String data,int age,long mobileNo) {
            this.data = data;
            this.age = age;
            this.mobileNo = mobileNo;
        }
    }

    class Head {
        Node front;
        Node rear;

        Head() {
            super();
            front = null;
            rear = null;
        }
    }

    // ENQUEUE METHOD
    public void enqueue1(String data,int age,long mobileNo) {
        Node newnode = new Node(data,age,mobileNo);
        newnode.data = data;
        newnode.age = age;
        newnode.mobileNo = mobileNo;
        if (head.front == null) {
            head.front = newnode;
            head.rear = newnode;
        } else {
            head.rear.next = newnode;
            head.rear = newnode;
        }
    }

    // DEQUEUE METHOD
    public void dequeue() {
        if (head.front == null && head.rear == null) {
            System.out.println("No patient in queue");
            return;
        }
        System.out.println("Patient to get treatment: ");
        Formatter fmt = new Formatter();
        System.out.format("%15s\t %15s\t %15s\n", "Name", "Age","PhoneNumber");
        System.out.format("%15s\t %15s\t %15s\n", head.front.data, head.front.age,head.front.mobileNo);
        head.front = head.front.next;
    }

    // DISPLAY METHOD
    public void display() {
        if (head == null) {
            System.out.println("No patient in queue");
            return;
        }
        Formatter fmt = new Formatter();
        System.out.format("%15s\t %15s\t %15s\n", "Name", "Age","PhoneNumber");
        
        Node last = head.front;
        while (last != null) {
            // System.out.println(last.data);
            System.out.format("%15s\t %15s\t %15s\n", last.data, last.age,last.mobileNo);
            last = last.next;
        }
    }

    // DISPLAY FRONT METHOD
    public void queueFront(Hospital que) {
        if (que.head == null) {
            System.out.println("No patient in queue");
        } else {
            Node last = head.front;
            System.out.println("Patient waiting for doctor:");
            Formatter fmt = new Formatter();
            System.out.format("%15s\t %15s\t %15s\n", "Name", "Age","PhoneNumber");
            System.out.format("%15s\t %15s\t %15s\n", last.data, last.age,last.mobileNo);
        }
    }

    // DISPLAY REAR METHOD
    public void queueRear(Hospital que) {
        if (que.head == null) {
            System.out.println("No patient in queue");
        } else {
            Node last = head.rear;
            System.out.println("Patient to get treated last:");
            Formatter fmt = new Formatter();
            System.out.format("%15s\t %15s\t %15s\n", "Name", "Age","PhoneNumber");
            System.out.format("%15s\t %15s\t %15s\n", last.data, last.age,last.mobileNo);
        }
    }

    public static void main(String args[]) {
        int b, p, r,cnt=0,cnt1=0,cnt2=0,cnt3=0;
        Scanner sc1 = new Scanner(System.in);
        Hospital obj1 = new Hospital();
        Hospital obj2 = new Hospital();
        Hospital obj3 = new Hospital();
        System.out.println("\n\t\t * HOSPITAL *");
        do {
            System.out.println("\nEnter the treatment no. you want to perform :");
            System.out.println("1)Patient visiting hospital");
            System.out.println("2)Patient to get treatmentT");
            System.out.println("3)Patient waiting for doctor");
            System.out.println("4)Patient to get treated last");
            System.out.println("\nENTER YOUR CHOICE :");
            int e = sc1.nextInt();
            System.out.println();
            switch (e) {
                case 1:
                    do {
                        System.out.println("1)Emergency");
                        System.out.println("2)Operation/admission");
                        System.out.println("3)OPD");
                        System.out.println("ENTER YOUR CHOICE :");
                        r = sc1.nextInt();
                        System.out.println();
                        switch (r) {
                            case 1:
                                System.out.println("Enter the name of patient");
                                String data = sc1.next();
                                System.out.println("Enter the age of patient:");
                                int age = sc1.nextInt();
                                System.out.println("Enter the Moblie Number of patient:");
                                long mobileNo = sc1.nextLong();
                                obj1.enqueue1(data,age,mobileNo);
                                System.out.println("\nEMERGENCY QUEUE :");
                                obj1.display();
                                cnt1++;
                                System.out.println("Total patients in EMERGENCY QUEUE :" +cnt1);
                                break;
                            case 2:
                                System.out.println("Enter the name of patient");
                                String data1 = sc1.next();
                                System.out.println("Enter the age of patient:");
                                int age1 = sc1.nextInt();
                                System.out.println("Enter the Moblie Number of patient:");
                                long mobileNo1 = sc1.nextLong();
                                obj2.enqueue1(data1,age1,mobileNo1);
                                
                                System.out.println("\nOPERATION QUEUE :");
                                obj2.display();
                                cnt2++;
                                System.out.println("Total patients in OPERATION QUEUE :" +cnt2);
                                break;
                            case 3:
                                System.out.println("Enter the name of patient");
                                String data2 = sc1.next();
                                System.out.println("Enter the age of patient:");
                                int age2 = sc1.nextInt();
                                System.out.println("Enter the Moblie Number of patient:");
                                long mobileNo2 = sc1.nextLong();
                                obj3.enqueue1(data2,age2,mobileNo2);
                                System.out.println("\nOPD QUEUE :");
                                obj3.display();
                                cnt3++;
                                System.out.println("Total patients in OPD QUEUE :" +cnt3);
                                break;
                            // case 4:
                            //     break;
                            default:
                                System.out.println("INVALID CHOICE!");
                                break;
                        }
                        System.out.println("\nIs there any other patient ?(Yes=1 and No=0)");
                        p = sc1.nextInt();
                    } while (p == 1);
                    break;
                case 2:
                    cnt=cnt1+cnt2+cnt3;
                    if (obj1.head.front != null) {
                        obj1.dequeue();
                        cnt--;
                        System.out.println("Total patients waiting:" + cnt);
                        break;
                    }
                    if (obj1.head.front == null && obj2.head.front != null) {
                        obj2.dequeue();
                        cnt--;
                        System.out.println("Total patients waiting:" + cnt);
                        break;
                    }
                    if (obj2.head.front == null && obj3.head.front != null) {
                        obj3.dequeue();
                        cnt--;
                        System.out.println("Total patients waiting:" + cnt);
                        break;
                    }
                    break;
                case 3:
                    if (obj1.head.front != null) {
                        obj1.queueFront(obj1);
                        break;
                    }
                    if (obj1.head.front == null && obj2.head.front != null) {
                        obj2.queueFront(obj2);
                        break;
                    }
                    if (obj2.head.front == null && obj3.head.front != null) {
                        obj3.queueFront(obj3);
                        break;
                    }
                    break;
                case 4:
                    if (obj3.head.rear != null) {
                        obj3.queueRear(obj3);
                        break;
                    }
                    if (obj3.head.rear == null && obj2.head.rear != null) {
                        obj2.queueRear(obj2);
                        break;
                    }
                    if (obj2.head.rear == null && obj1.head.rear != null) {
                        obj1.queueRear(obj1);
                        break;
                    }
                    break;
            }
            System.out.println("\nDo you want to perform treatment ?(Yes=1/No=0)");
            b = sc1.nextInt();
        } while (b == 1);
        System.out.println("\t\t * THANK YOU *");
    }
}

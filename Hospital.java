import java.util.*;

public class Hospital {
	Head head = new Head();

	class Node {
		String data;
		Node next;

		public Node(String data) {
			this.data = data;
		}
	}

	class Head {
		int count;
		Node front;
		Node rear;

		Head() {
			super();
			count = 0;
			front = null;
			rear = null;

		}
	}

	//ENQUEUE METHOD
	public void enqueue1(String data) {

		Node newnode = new Node(data);
		if (head.front == null) {
			head.front = newnode;
			head.rear = newnode;
		} else {
			head.rear.next = newnode;
			head.rear = newnode;
		}
		head.count++;

		System.out.println("Total patients:" + head.count);
	}

	//DEQUEUE METHOD
	public void dequeue() {
		if (head.front == null && head.rear == null) {
			System.out.println("No patient in queue");
			return;
		}
		System.out.println("Patient to get treatment: " + head.front.data);
		head.front = head.front.next;
		head.count--;
		System.out.println("Total patients:" + head.count);
	}

	//DISPLAY METHOD
	public void display() {
		if (head == null) {
			System.out.println("No patient in queue");
			return;
		}
		Node last = head.front;
		while (last != null) {
			System.out.println(last.data);
			last = last.next;
		}
	}

	//DISPLAY FRONT METHOD
	public void queueFront(Hospital que) {
		if (que.head == null) {
			System.out.println("No patient in queue");
		} else {
			Node last = head.front;
			System.out.println("Patient waiting for doctor:" + last.data);
		}
	}

	//DISPLAY REAR METHOD
	public void queueRear(Hospital que) {
		if (que.head == null) {
			System.out.println("No patient in queue");
		} else {
			Node last = head.rear;
			System.out.println("Patient to get treated last:" + last.data);
		}
	}

	public static void main(String args[]) {
		int b, p, r;
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
			switch (e) {
			case 1:
				do {
					System.out.println("1)Emergency");
					System.out.println("2)Operation/admission");
					System.out.println("3)OPD");
					System.out.println("4)Back to continue");
					System.out.println("ENTER YOUR CHOICE :");
					r = sc1.nextInt();
					switch (r) {
					case 1:
						System.out.println("Enter the name of patient");
						String data = sc1.next();
						obj1.enqueue1(data);
						System.out.println("\nEMERGENCY QUEUE :");
						obj1.display();
						break;
					case 2:
						System.out.println("Enter the name of patient");
						String data1 = sc1.next();
						obj2.enqueue1(data1);
						System.out.println("\nOPERATION QUEUE :");
						obj2.display();
						break;
					case 3:
						System.out.println("Enter the name of patient");
						String data2 = sc1.next();
						obj3.enqueue1(data2);
						System.out.println("\nOPD QUEUE :");
						obj3.display();
						break;
					case 4:
						break;
					}
					System.out.println("Is there any other patient ?(Yes=1 and No=0)");
					p = sc1.nextInt();
				} while (p == 1);
				break;

			case 2:
				if (obj1.head.front != null) {
					obj1.dequeue();
					break;
				}
				if (obj1.head.front == null && obj2.head.front != null) {
					obj2.dequeue();
					break;
				}
				if (obj2.head.front == null && obj3.head.front != null) {
					obj3.dequeue();
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
			System.out.println("Do you want to perform treatment ?(Yes=1/No=0");
			b = sc1.nextInt();
		} while (b == 1);
		System.out.println("\t\t * THANK YOU *");
	}
}
/**
*@author Marcus Duree
*@version 20170217
*
*/

public class ResizeIntStack {
		private int[] item;
		private int top;
		/**
		*Constructor for objects of class ResizeIntStack
		*/
		public ResizeIntStack(){
			item = new int[1];
			top = -1;
		}
		/**
		*inserts given value to top of stack
		*@param int x
		*
		*/
		public void push(int x){
			if (isFull())
				resize(2*item.length);
			item[++top]=x;
		}
		/**
		*Returns the top value of the stack and removes it from the stack
		*If stack is at a quarter capacity or less, resizes stack to half the current size
		*
		*/
		public int pop(){
			if (isEmpty()){
				System.out.println("Stack Underflow");
				System.exit(1);
			}
			int temp = item[top--];
			if(top == item.length/4)
				resize(item.length/2);
			return temp;
				
		}
		/**
		*Checks if stack is empty
		*
		*
		*/
		public boolean isEmpty(){
			return top == -1;
		}
		/**
		*Checks if stack is full
		*
		*
		*/
		public boolean isFull(){
			return top == item.length-1;
		}
		/**
		*Clears all stores values from the stack
		*
		*
		*/
		public void clear(){
			item = new int[1];
			top = -1;
		}
		/**
		*Resizes the stack to twice the size of the parameter
		*@ param int size
		*
		*/
		private void resize(int size){
			int[] temp = new int [size];
			for (int i = 0;i<=top;i++)
				temp[i]=item[i];
			item = temp;
		}
		/**
		*Returns the value at the top of the stack
		*
		*
		*/
		public int top(){
			if (isEmpty()){
				System.out.println("Stack Underflow");
				System.exit(1);
			}
			return item[top];
		}
	}

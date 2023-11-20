/**
 * 
 */
package textgen;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;


import org.junit.Before;
import org.junit.Rule;



public class MyLinkedListTester {

    private static final int LONG_LIST_LENGTH =10;

    MyLinkedList<String> shortList;
    MyLinkedList<Integer> emptyList;
    MyLinkedList<Integer> longerList;
    MyLinkedList<Integer> list1;

    /**
     * @throws java.lang.Exception
     */
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setUp() throws Exception {
        // Feel free to use these lists, or add your own
        shortList = new MyLinkedList<String>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new MyLinkedList<Integer>();
        longerList = new MyLinkedList<Integer>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++)
        {
            longerList.add(i);
        }
        list1 = new MyLinkedList<Integer>();
        list1.add(65);
        list1.add(21);
        list1.add(42);

    }


    /** Test if the get method is working correctly.
     */
    /*You should not need to add much to this method.
     * We provide it as an example of a thorough test. */
    @Test
    public void testGet()
    {
        //test empty list, get should throw an exception
        try {
            emptyList.get(0);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }

        // test short list, first contents, then out of bounds
        assertEquals("Check first", "A", shortList.get(0));
        assertEquals("Check second", "B", shortList.get(1));

        try {
            shortList.get(-1);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }
        try {
            shortList.get(2);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }
         //test longer list contents
        for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
            assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
        }

        // test off the end of the longer array
        try {
            longerList.get(-1);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }
        try {
            longerList.get(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        }

    }


    /** Test removing an element from the list.
     * We've included the example from the concept challenge.
     * You will want to add more tests.  */
    @Test
    public void testRemove()
    {
    	
        try {
        	longerList.remove(longerList.size());
        	fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
        
        try {
            longerList.remove(2000000000);
            fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
        
        try {
            longerList.remove(-1);
            fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
        
        try {
            longerList.remove(-2000000000);
            fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
        
        int a = list1.remove(0);
        
        assertEquals("Remove: check a is correct ", 65, a);
        assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
        assertEquals("Remove: check size is correct ", 2, list1.size());
    }

    /** Test adding an element into the end of the list, specifically
     *  public boolean add(E element)
     * */
    @Test
    public void testAddEnd()
    {
        assertEquals(0, emptyList.size());
        assertEquals(2, shortList.size());
        assertEquals(10, longerList.size());
        assertEquals(3, list1.size());

        emptyList.add(155);
        assertEquals((Integer) 155, emptyList.get(emptyList.size() - 1));
        emptyList.add(195);
        assertEquals((Integer) 195, emptyList.get(emptyList.size() - 1));
        assertEquals(2, emptyList.size());

        expectedException.expect(NullPointerException.class);
        emptyList.add(null);
    }


    /** Test the size of the list */
    @Test
    public void testSize() {
        assertEquals(0, emptyList.size());
        assertEquals(2, shortList.size());
        assertEquals(10, longerList.size());
        assertEquals(3, list1.size());
    }



    /** Test adding an element into the list at a specified index,
     * specifically:
     * public void add(int index, E element)
     * */
    @Test
    public void testAddAtIndex() {
//        longerList.printList();
   
    	expectedException.expect(NullPointerException.class);
        longerList.add(2, null);
        
        try {
        	longerList.add(longerList.size(), 99);
        	fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        	
        }
        
        try {
            longerList.add(2000000000, 99);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        	
        }
        
        try {
            longerList.add(-1, 99);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        	
        }
        
        try {
            longerList.add(-2000000000, 99);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        	
        }

        //longerList.printList();
        longerList.add(longerList.size / 2, 6);
        //longerList.printList();
        assertEquals( (Integer) (6), longerList.get(longerList.size() / 2 - 1));
        //longerList.printFromTail();

        longerList.add(0, 999);
        assertEquals((Integer) 999, longerList.get(0));

        longerList.add(longerList.size - 1, 10);
        assertEquals((Integer) 10, longerList.get(longerList.size - 1));

//        longerList.printList();

        longerList.add(1, -1);
        assertEquals( (Integer) (-1), longerList.get(1));
//        longerList.printList();
        longerList.add(longerList.size() - 2, -10);
//        longerList.printList();
        assertEquals( (Integer) (-10), longerList.get(longerList.size() - 3));
    }

    /** Test setting an element in the list */
    @Test
    public void testSet() {
//        longerList.printList();

    	expectedException.expect(NullPointerException.class);
        longerList.set(2, null);
        
        try {
        	longerList.set(longerList.size(), 99);
        	fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        	
        }
        
        try {
            longerList.set(2000000000, 99);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        	
        }
        
        try {
            longerList.set(-1, 99);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        	
        }
        
        try {
            longerList.set(-2000000000, 99);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        	
        }
       
        assertEquals((Integer) 0, longerList.set(0, 11));
        assertEquals((Integer) 1, longerList.set(1, -1));

        assertEquals((Integer) 8, longerList.set(8, -8));
        assertEquals((Integer) 9, longerList.set(9, -9));

        assertEquals((Integer) 4, longerList.set(4, -4));
//        longerList.printList();
    }

}

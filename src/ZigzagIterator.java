import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * For example, given two 1d vectors: v1 = [1, 2] v2 = [3, 4, 5, 6]
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1, 3, 2, 4, 5, 6].
 * 
 * @author cassie9082
 * 
 */
public class ZigzagIterator {
	// Option 1: Time o(n), Space o(n)
	// private Iterator<Integer> i, j, temp;
	//
	// public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	// i = v1.iterator();
	// j = v2.iterator();
	// }
	//
	// public int next() {
	// if (i.hasNext()) {
	// temp = i;
	// i = j;
	// j = temp;
	// }
	// return j.next();
	// }
	//
	// public boolean hasNext() {
	// return i.hasNext() || j.hasNext();
	// }
	
	// ***************************************************
	
	// Option 2: Time o(n), Space o(1)
	Iterator<Integer> itr1;
	Iterator<Integer> itr2;
	int count;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.itr1 = v1.iterator();
		this.itr2 = v2.iterator();
		count = 0;
	}

	public boolean hasNext() {
		return itr1.hasNext() || itr2.hasNext();
	}

	public int next() {
		if (!hasNext()) {
			return 0;
		}

		count++;
		if ((count % 2 == 1 && itr1.hasNext()) || !itr2.hasNext()) {
			return itr1.next();
		} else if ((count % 2 == 0 && itr2.hasNext()) || !itr1.hasNext()) {
			return itr2.next();
		}
		return 0;
	}

	public static void main(String[] args) {
		List<Integer> v1 = new ArrayList<Integer>();
		v1.add(1);
		v1.add(2);
		List<Integer> v2 = new ArrayList<Integer>();
		v2.add(3);
		v2.add(4);
		v2.add(5);
		v2.add(6);
		ZigzagIterator zi = new ZigzagIterator(v1, v2);
		while (zi.hasNext()) {
			System.out.print(zi.next());
		}
	}
}

// 如果输入是k个列表呢？
/*
 * 使用一个迭代器的列表来管理这些迭代器。用turns变量和取模来判断我们该取列表中的第几个迭代器。不同点在于，一个迭代器用完后，我们要将其从列表中移出，
 * 这样我们下次就不用再找这个空的迭代器了
 * 。同样，由于每用完一个迭代器后都要移出一个，turns变量也要相应的更新为该迭代器下标的上一个下标。如果迭代器列表为空，说明没有下一个了。
 */
class ZigzagIterator2 {
    
    List<Iterator<Integer>> itlist;
    int turns;

    public ZigzagIterator2(List<Iterator<Integer>> list) {
        this.itlist = new LinkedList<Iterator<Integer>>();
        // 将非空迭代器加入列表
        for(Iterator<Integer> it : list){
            if(it.hasNext()){
                itlist.add(it);
            }
        }
        turns = 0;
    }

    public Integer next() {
        if(!hasNext()){
            return 0;
        }
        Integer res = 0;
        // 算出本次使用的迭代器的下标
        int pos = turns % itlist.size();
        Iterator<Integer> curr = itlist.get(pos);
        res = curr.next();
        // 如果这个迭代器用完，就将其从列表中移出
        if(!curr.hasNext()){
            itlist.remove(turns % itlist.size());
            // turns变量更新为上一个下标
            turns = pos - 1;
        }
        turns++;
        return res;
    }

    public boolean hasNext() {
        return itlist.size() > 0;
    }
}

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 * @author cassie9082
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
        StringBuilder num = new StringBuilder();
        int[] f = new int[n + 1]; //n + 1是因为还要放f[0]
        
        f[0] = 1;
        for(int i = 1; i <= n; i++){
            num.append(i);
            f[i] = f[i - 1] * i;
        }
        
        k = k - 1;
        StringBuilder str = new StringBuilder();
        for(int i = n; i >= 1; i--){
            int index = k / f[i - 1];
            str.append(num.charAt(index));
            num.deleteCharAt(index);
            k = k % f[i - 1];
        }
        return str.toString();
    }
}

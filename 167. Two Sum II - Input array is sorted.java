O(n)
public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
        if (numbers[l] + numbers[r] > target) r--;
        else l++;
    }
    return new int[]{l + 1, r + 1};
}
we use l and r to denote the first index and second index respectively.

When the sum is:

smaller than the target:

we move l to the right by 1. we can't make r smaller because that's gonna make the sum even smaller.
bigger than target:

move r to the left by 1. we can't make l bigger because that's gonna make the sum even bigger.
equal to the target:

we found the answer and return.
Since the question said there is EXACTLY one solution and didn't provide any info about when there is no valid answer, so we can always assume there is one and only one answer, which means l and r never across each other.

Another thing to notice is that this array is sorted.
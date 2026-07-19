import java.util.*;

public class Solution {

    public long maxAlternatingSum(int[] nums, int k) {

        int[] bralvoteni = nums;
        int n = nums.length;

        // Coordinate Compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }

        int size = rank;

        long[] up = new long[n];
        long[] down = new long[n];

        SegmentTree upTree = new SegmentTree(size);
        SegmentTree downTree = new SegmentTree(size);

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int idx = map.get(nums[i]);

            up[i] = nums[i];
            down[i] = nums[i];

            if (i - k >= 0) {
                int prevIdx = map.get(nums[i - k]);
                upTree.update(prevIdx, up[i - k]);
                downTree.update(prevIdx, down[i - k]);
            }

            // nums[j] < nums[i]
            if (idx > 0) {
                long best = downTree.query(0, idx - 1);
                up[i] = Math.max(up[i], best + nums[i]);
            }

            // nums[j] > nums[i]
            if (idx < size - 1) {
                long best = upTree.query(idx + 1, size - 1);
                down[i] = Math.max(down[i], best + nums[i]);
            }

            ans = Math.max(ans, Math.max(up[i], down[i]));
        }

        return  ans;
    }

    static class SegmentTree {
        long[] tree;
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new long[4 * n];
        }

        void update(int idx, long val) {
            update(0, 0, n - 1, idx, val);
        }

        void update(int node, int l, int r, int idx, long val) {
            if (l == r) {
                tree[node] = Math.max(tree[node], val);
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid) update(2 * node + 1, l, mid, idx, val);
            else update(2 * node + 2, mid + 1, r, idx, val);

            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }

        long query(int ql, int qr) {
            return query(0, 0, n - 1, ql, qr);
        }

        long query(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) return tree[node];

            int mid = (l + r) / 2;
            return Math.max(
                query(2 * node + 1, l, mid, ql, qr),
                query(2 * node + 2, mid + 1, r, ql, qr)
            );
        }
    }
}
package leetcode;

/*
LC Hard : https://leetcode.com/problems/find-in-mountain-array/
* **/
public class FindInMountainArray {

    public static void main(String[] args) {

    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = getPeakIndex( mountainArr);
        int index = binarySearch(mountainArr, 0, peak, target);
        if(index!=-1) {
            return index;
        } else {
            return binarySearch(mountainArr, peak+1, mountainArr.length(), target);
        }
    }
    public static int getPeakIndex( MountainArray mountainArray) {
        int start = 0; int end = mountainArray.length();
        while(start<end) {
            int mid = start+(end-start)/2;
            if(mountainArray.get(mid)>mountainArray.get(mid+1)) {
                end = mid;
            } else {
                start=mid+1;
            }
        }
        return start;
    }

    private static int binarySearch(MountainArray mountainArray, int i, int j, int target) {
        boolean isAscending = mountainArray.get(i) < mountainArray.get(j);
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(mountainArray.get(mid)==target)
                return mid;
            if(isAscending) {
                if(target<mountainArray.get(mid)) {
                    j = mid-1;
                } else {
                    i=mid+1;
                }
            }
            else {
                if(target>mountainArray.get(mid)) {
                    j = mid-1;
                } else {
                    i=mid+1;
                }
            }
        }
        return -1;
    }
}

class MountainArray {

    public int length() {
        return 0;
    }

    public int get(int mid) {
        return 0;
    }
}

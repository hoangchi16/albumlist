public class AlbumArrayList extends AlbumList {
    public Album[] arrayList;
    private int size;

    public AlbumArrayList() {
        this(8);
    }

    public AlbumArrayList(int size_) {
        numItems = 0;
        size = size_;
        arrayList = new Album[size];
    }

    public int getCapacity() {
        return size;
    }

    private boolean isFull() {
        return numItems == size;
    }

    private void doubleLength() {
        Album[] newArray = new Album[size*2];
        for (int i = 0; i < size; i++) {
            newArray[i] = arrayList[i];
        }

        arrayList = new Album[size*2];
        arrayList = newArray;
        size = arrayList.length;
    }

    public void add(Album newA) {
        if (this.isFull()) {
            this.doubleLength();
        }

        set(numItems, newA);
        numItems += 1;
    }

    public Album remove(Album targetA) {
        int targetCoordinate = -1;
        for (int i = 0; i < numItems; i++) {
            if (arrayList[i].equals(targetA)) {
                targetCoordinate = i;
                break;
            }
        }
        return this.remove(targetCoordinate);
    }


    public Album remove(int idx) {
        Album removed = get(idx);
        if (removed != null) {
            for (int i = idx; i < numItems - 1; i++) {
                set(i, get(i+1));
            }
            numItems -= 1;
            return removed;
        } else {
            return null;
        }
        
    }

    private boolean checkValidIndex(int idx) {
        if (idx < 0 || idx >= numItems) {
            System.out.println("Album not found in list. Please re-enter command and try again.");
            return false;
        } else {
            return true;
        }
    }

    public Album get(int idx) {
        if (checkValidIndex(idx)) {
            return arrayList[idx];
        } else {
            return null;
        }
        
    }

    public void set(int idx, Album newA) {
        arrayList[idx] = newA;
    }

    public void getList() {
        System.out.println("--" + numItems + " albums--");
        for (int i = 0; i < numItems; i++) {
            System.out.println((i+1) + ". " + arrayList[i]);
        }
    }
}
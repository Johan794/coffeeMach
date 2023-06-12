public class CacheData<T> {
    private T data;
    private long expirationTime;

    public CacheData(T data, long expirationTime){
        this.data = data;
        this.expirationTime = expirationTime;
    }

     public T getData() {
        return data;
    }

    public long getExpirationTime() {
        return expirationTime;
    }
}

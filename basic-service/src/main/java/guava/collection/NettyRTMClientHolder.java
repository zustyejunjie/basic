package guava.collection;


import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NettyRTMClientHolder {
	private final RTMEndPoint endPoint;
	private final long chid;
	private final Set<String> topics = new HashSet<>();
    private final Map<String,Object> properties = new ConcurrentHashMap<>();
    public static final String RTC_BUSY = "rtcBusy";
	public static final String RTC_STATUS = "rtcStatus";
	
	public NettyRTMClientHolder(RTMEndPoint endPoint, long chid){
		this.endPoint = endPoint;
		this.chid = chid;
	}

	public long getChid() {
		return chid;
	}

	public RTMEndPoint getEndPoint() {
		return endPoint;
	}
	
	public void addTopic(String topic){
		topics.add(topic);
	}
	
	public void addTopics(Collection<String> topics){
		topics.addAll(topics);
	}
	
	public boolean containsTopic(String topic){
		return topics.contains(topic);
	}
	
	public Set<String> getTopics(){
		return topics;
	}

    public void setProperty(String nm,Object v){
        properties.put(nm,v);
    }

    public void removeProperty(String nm){
        properties.remove(nm);
    }

    public <T> T getProperty(String nm,Class<T> t){
        Object v = properties.get(nm);
        if(v == null){
            return null;
        }
        return (T)v;
    }
}

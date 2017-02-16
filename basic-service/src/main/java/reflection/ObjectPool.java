package reflection;

/**
 * Created by yejunjie on 2017/2/16.
 */
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;


/**
 * 对象池
 */
public class ObjectPool {

    private Map<String, Object> pool;

    private ObjectPool(Map<String, Object> pool) {
        this.pool = pool;
    }

    private static Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(className).newInstance();
    }

    private static JSONArray getObjects(String config) throws IOException {
        Reader reader = new InputStreamReader(ClassLoader.getSystemResourceAsStream(config));
        return JSONObject.parseObject(CharStreams.toString(reader)).getJSONArray("objects");
    }

    // 根据指定的JSON配置文件来初始化对象池
    public static ObjectPool init(String config) {
        try {
            JSONArray objects = getObjects(config);
            ObjectPool pool = new ObjectPool(new HashMap<String, Object>());
            if (objects != null && objects.size() != 0) {
                for (int i = 0; i < objects.size(); ++i) {
                    JSONObject object = objects.getJSONObject(i);
                    if (object == null || object.size() == 0) {
                        continue;
                    }
                    String id = object.getString("id");
                    String className = object.getString("class");

                    pool.putObject(id, getInstance(className));
                }
            }
            return pool;
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getObject(String id) {
        return pool.get(id);
    }

    public void putObject(String id, Object object) {
        pool.put(id, object);
    }

    public void clear() {
        pool.clear();
    }
}
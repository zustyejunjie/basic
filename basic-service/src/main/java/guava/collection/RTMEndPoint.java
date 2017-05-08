package guava.collection;

public class RTMEndPoint {
	private  String userId;
	private  String roleId;
	private  String manageUnit;
	private  Integer tokenId;
	private  String client;
	private String version;
	private Integer deviceId;
	
	public RTMEndPoint(){
		
	}
	
	public RTMEndPoint(String userId, String roleId, Integer tokenId, String manageUnit, String client){
		this.userId = userId;
		this.roleId = roleId;
		this.tokenId = tokenId;
		this.manageUnit = manageUnit;
		this.client=client;
	}
	
	public RTMEndPoint(String userId, Integer tokenId){
		this(userId,null,tokenId,null,null);
	}
	
	public RTMEndPoint(String userId){
		this(userId,null,null,null,null);
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setManageUnit(String manageUnit) {
		this.manageUnit = manageUnit;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	public void setVersion(String version) {this.version = version;}

	public String getUserId() {
		return userId;
	}
	
	public String getRoleId() {
		return roleId;
	}
	
	public String getManageUnit() {
		return manageUnit;
	}
	
	public Integer getTokenId() {
		return tokenId;
	}

	public String getVersion() {return version;}

	public String getClient() {return client;}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
}

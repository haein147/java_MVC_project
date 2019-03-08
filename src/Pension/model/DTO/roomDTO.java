/*CREATE TABLE room (
       room_name            VARCHAR2(20) PRIMARY KEY,
       room_limit            NUMBER(2) NOT NULL,
       clean_ok            VARCHAR2(20)
);*/

package Pension.model.DTO;

public class roomDTO {
	private String roomName;
	private int roomLimit;
	private String cleanOk;
	public roomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public roomDTO(String roomName, int roomLimit, String cleanOk) {
		super();
		this.roomName = roomName;
		this.roomLimit = roomLimit;
		this.cleanOk = cleanOk;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomLimit() {
		return roomLimit;
	}
	public void setRoomLimit(int roomLimit) {
		this.roomLimit = roomLimit;
	}
	public String getCleanOk() {
		return cleanOk;
	}
	public void setCleanOk(String cleanOk) {
		this.cleanOk = cleanOk;
	}
	@Override
	public String toString() {
		return "객실 이름 : " + roomName + ", 객실 인원 : " + roomLimit + ", 청소 여부 : " + cleanOk + "\n";
	}
	
}


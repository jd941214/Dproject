package team.Dproject.main.hotel.model;

public class RoomDTO {
	private int room_no;
	private int hotel_no; 
	private String name;
	private int roomsize;
	private int sleeps;
	private String item;
	private String filename; 
	private int filesize;
	private int price;
	
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public int getHotel_no() {
		return hotel_no;
	}
	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoomsize() {
		return roomsize;
	}
	public void setRoomsize(int roomsize) {
		this.roomsize = roomsize;
	}
	public int getSleeps() {
		return sleeps;
	}
	public void setSleeps(int sleeps) {
		this.sleeps = sleeps;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

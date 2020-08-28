package team.Dproject.main.hotel.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class RFileDTO {
	private List<MultipartFile> rfile;
	private int room_no;
	
	public List<MultipartFile> getRfile() {
		return rfile;
	}
	public void setRfile(List<MultipartFile> files) {
		this.rfile = files;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
}

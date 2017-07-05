package tzuchi.donation.orm;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the test01.donate database table.
 * 
 */
@Entity(name = "DonationVO")
@Table(name = "donate")
public class DonationVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(length = 7)
	private String member_id;
	private Date date;
	private Integer amount;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private MemberVO member;

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}

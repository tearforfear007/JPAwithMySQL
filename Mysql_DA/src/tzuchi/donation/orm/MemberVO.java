package tzuchi.donation.orm;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the test01.member database table.
 * 
 */
@Entity
@Table(name = "member")
public class MemberVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 7)
	private String member_id;

	@Column(length = 45)
	private String name;

	@Column(length = 10)
	private String uid;

	@OneToMany(mappedBy = "member",fetch=FetchType.LAZY)
	private Set<DonationVO> donations;

	public Set<DonationVO> getDonations() {
		return donations;
	}

	public void setDonations(Set<DonationVO> donations) {
		this.donations = donations;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}
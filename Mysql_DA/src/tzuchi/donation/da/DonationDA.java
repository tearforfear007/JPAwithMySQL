package tzuchi.donation.da;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import tzuchi.donation.orm.DonationVO;
import tzuchi.donation.util.JPAUtil;

@SuppressWarnings("unchecked")
public class DonationDA {
	private EntityManager em;

	public List<DonationVO> queryAll() {
		List<DonationVO> resultList = null;
		em = JPAUtil.getEntityManagerFactory().createEntityManager();

		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("select d from DonationVO d");

		try {
			Query query = em.createQuery(sqlBuf.toString());

			resultList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return resultList;
	}

	public List<DonationVO> queryOne(String member_id) {
		List<DonationVO> resultList = null;
		em = JPAUtil.getEntityManagerFactory().createEntityManager();

		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("select d from DonationVO d where d.member_id=:member_id");

		try {
			Query query = em.createQuery(sqlBuf.toString()).setParameter("member_id", member_id);
			resultList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return resultList;

	}
}

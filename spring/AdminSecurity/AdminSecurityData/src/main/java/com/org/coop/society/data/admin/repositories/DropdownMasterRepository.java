package com.org.coop.society.data.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.coop.society.data.admin.entities.DropdownMaster;

public interface DropdownMasterRepository extends JpaRepository<DropdownMaster, String> {
	public List<DropdownMaster> findByCategory(String category);
	
	@Query("select dm from DropdownMaster dm where dm.code not in "
			+ "(select id.dropdownMaster.code from InactiveDropdown id where "
			+ "(id.branchMaster.branchId = :branchId or id.branchMaster.parentId = :branchId)) "
			+ "order by dm.category, dm.code")
	public List<DropdownMaster> findActiveDropdown(@Param("branchId") int branchId);
}

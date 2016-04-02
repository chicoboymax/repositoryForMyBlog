package com.org.coop.retail.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.coop.canonical.beans.UIModel;
import com.org.coop.retail.servicehelper.MaterialSetupServiceHelperImpl;
import com.org.coop.retail.servicehelper.RetailBranchSetupServiceHelperImpl;

@Service
public class MaterialSetupServiceImpl {

	private static final Logger log = Logger.getLogger(MaterialSetupServiceImpl.class); 
	
	@Autowired
	private MaterialSetupServiceHelperImpl materialSetupServiceHelperImpl;
	
	
	public UIModel getMaterialGroup(int branchId, int materialGroupId) {
		return materialSetupServiceHelperImpl.getMaterialGroup(branchId, materialGroupId);
	}
	
	public UIModel saveMaterialGroup(UIModel uiModel) {
		uiModel = materialSetupServiceHelperImpl.saveMaterialGroup(uiModel);
		if(uiModel.getErrorMsg() != null) {
			return uiModel;
		}
		int materialGroupId = uiModel.getBranchBean().getMaterialGroups().get(0).getMaterialGrpId();
		int branchId = uiModel.getBranchBean().getBranchId();
		return materialSetupServiceHelperImpl.getMaterialGroup(branchId, materialGroupId);
	}
	
	public UIModel deleteMaterialGroup(UIModel uiModel) {
		uiModel = materialSetupServiceHelperImpl.deleteMaterialGroup(uiModel);
		if(uiModel.getErrorMsg() != null) {
			return uiModel;
		}
		int branchId = uiModel.getBranchBean().getBranchId();
		return materialSetupServiceHelperImpl.getMaterialGroup(branchId, 0);
	}
	
	public UIModel getMaterial(int branchId, int materialId) {
		return materialSetupServiceHelperImpl.getMaterial(branchId, materialId);
	}
	
	public UIModel saveMaterial(UIModel uiModel) {
		uiModel = materialSetupServiceHelperImpl.saveMaterial(uiModel);
		if(uiModel.getErrorMsg() != null) {
			return uiModel;
		}
		int materialId = uiModel.getBranchBean().getMaterialGroups().get(0).getMaterials().get(0).getMaterialId();
		int branchId = uiModel.getBranchBean().getBranchId();
		return materialSetupServiceHelperImpl.getMaterial(branchId, materialId);
	}
	
	public UIModel deleteMaterial(UIModel uiModel) {
		uiModel = materialSetupServiceHelperImpl.deleteMaterial(uiModel);
		if(uiModel.getErrorMsg() != null) {
			return uiModel;
		}
		int branchId = uiModel.getBranchBean().getBranchId();
		return materialSetupServiceHelperImpl.getMaterial(branchId, 0);
	}
}

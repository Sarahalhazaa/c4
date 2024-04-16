package com.example.mylaundry.Service;

import com.example.mylaundry.Api.ApiException;
import com.example.mylaundry.Model.Branch;
import com.example.mylaundry.Repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public List<Branch> getBranch() {
        return branchRepository.findAll();
    }

//    public void addBranch( Integer LaundryId, Branch branch) {
//        Laundry laundry = LaundryRepository.findMerchantsById(LaundryId);
//        if (laundry == null) {
//            throw new ApiException("LaundryId not found");
//        }
//        branch.setLaundry(laundry);
//        branchRepository.save(branch);
//    }
    public void updateBranch(Integer id, Branch branch) {
        Branch branch1 = branchRepository.findBranchById(id);
        if (branch1 == null) {
            throw new ApiException("id not found");
        }
        branch1.setDistrict(branch.getDistrict());
        branch1.setStreet(branch.getStreet());
        branchRepository.save(branch1);

    }

    public void deleteBranch(Integer id) {
        Branch branch1 = branchRepository.findBranchById(id);
        if (branch1 == null) {
            throw new ApiException("id not found");
        }
        branchRepository.delete(branch1);
    }

    //---------------------------  end CRUD  ---------------------------------


}

package com.poly.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.entity.Heo;
import com.poly.mapper.HeoMapper;
import com.poly.model.HeoDTO;
import com.poly.repository.IHeoRepository;
import com.poly.service.IWishlist;

@Service
@SessionScope
public class WishlistService implements IWishlist{
	@Autowired
	private IHeoRepository heoRepo;
	@Autowired
	private HeoMapper mapper;
   List<HeoDTO> wishlist = new ArrayList<HeoDTO>();
	@Override
	public List<HeoDTO> getCart() {
		
		return wishlist;
	}

	@Override
	public void addToWishlist(int productId) {
		boolean check = false;
		for (HeoDTO heoDTO : wishlist) {
			if(heoDTO.getId() == productId) {
				check = true;
			}
		}
		if(check == false) {
		Heo h  = this.heoRepo.getById(productId);
		this.wishlist.add(mapper.convertToDTO(h));
		}
		
	}

	@Override
	public void removeProduct(int productId) {
	for (HeoDTO heoDTO : wishlist) {
		if(heoDTO.getId() == productId) {
			this.wishlist.remove(heoDTO);
		}
		break;
	}
		
		
	}

	@Override
	public void removeProducts() {
		wishlist.clear();
		
	}

}

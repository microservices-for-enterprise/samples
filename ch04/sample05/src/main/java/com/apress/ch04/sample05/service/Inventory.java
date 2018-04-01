package com.apress.ch04.sample05.service;

import com.apress.ch04.sample05.services.ItemList;
import com.apress.ch04.sample05.services.UpdateItemsResp;

import java.util.List;

import org.lognet.springboot.grpc.GRpcService;

import com.apress.ch04.sample05.services.InventoryServiceGrpc.InventoryServiceImplBase;
import com.apress.ch04.sample05.services.Item;

import io.grpc.stub.StreamObserver;

@GRpcService
public class Inventory extends InventoryServiceImplBase{

	@Override
	public void updateItems(ItemList request, StreamObserver<UpdateItemsResp> responseObserver) {
		List<Item> items = request.getItemList();
		
		for (Item item : items) {
			System.out.println(item.getCode());
		}
		
		responseObserver.onNext(UpdateItemsResp.newBuilder().setCode("success").build());
		responseObserver.onCompleted();
	}
}

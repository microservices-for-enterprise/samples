package com.apress.ch04.sample05.service;

import com.apress.ch04.sample05.service.InventoryServiceGrpc.InventoryServiceImplBase;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.List;

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

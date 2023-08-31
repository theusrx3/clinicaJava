package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import entity.Cart;
import entity.Consult;

@Service
public class CartService {

	
	private List<Cart> items = new ArrayList<>();
	
	public List<Cart> ListItems(){
		return items;
	}
	
	public void removeItems(Consult consult) {
		items.removeIf(items -> items.getConsult().equals(consult));
	}
	
	public BigDecimal CalcTotal() {
		return items.stream().map(Cart::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);
				
	}
	
}

package com.stackroute.eplay.ticketengine.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.ticketengine.domain.BlockedSeats;
import com.stackroute.eplay.ticketengine.repository.BlockedSeatsRepository;
import com.stackroute.eplay.ticketengine.repository.ShowRepository;

@Service
public class BlockedSeatsServiceImpl implements BlockedSeatsService{

	private BlockedSeatsRepository blockedSeatsRepository;
	private RedisTemplate<String, Object> redisTemplate;
	private ShowRepository showRepository;
	
	@Autowired
	public BlockedSeatsServiceImpl(BlockedSeatsRepository blockedSeatsRepository, RedisTemplate<String, Object> redisTemplate, ShowRepository showRepository) {
		this.blockedSeatsRepository = blockedSeatsRepository;
		this.redisTemplate = redisTemplate;
		this.showRepository = showRepository;
	}

	@Override
	public BlockedSeats save(BlockedSeats blockedSeats) throws Exception{
		blockedSeats = blockedSeatsRepository.save(blockedSeats);
		System.out.println("BlockedSeats:"+blockedSeats.getId());
		redisTemplate.expire( "BlockedSeats:"+blockedSeats.getId(), 10, TimeUnit.SECONDS );
		/*System.out.println("--------1--------");
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		System.out.println("--------2--------");
        Jedis jedis = pool.getResource();
        System.out.println("--------3--------");
        jedis.expire(blockedSeats.getId(), 10);
        System.out.println("--------4--------");
        jedis.psubscribe(new KeyExpiredListener(), "__key*__:*");
        System.out.println("--------5--------");
        pool.close();
        jedis.close();*/
		/*Show show = showRepository.find(blockedSeats.getShowId());
		System.out.println("--------6--------");
		for(int i:blockedSeats.getSeats()) {
			System.out.println("--------7--------"+i);
			if(show.getSeats().get(i).equals("blocked")) {
				throw new Exception("Seat No: "+i+" is already blocked");
			} else {
				show.getSeats().put(i, "blocked");
			}
		}
		System.out.println("--------8--------");
		showRepository.save(show);*/
		return blockedSeats;
	}

	@Override
	public BlockedSeats findById(String id) {
		return blockedSeatsRepository.findById(id).get();
	}

	@Override
	public Iterable<BlockedSeats> getAll() {
		return blockedSeatsRepository.findAll();
	}

	@Override
	public void delete(String id) {
		blockedSeatsRepository.deleteById(id);
		
	}

	@Override
	public BlockedSeats update(BlockedSeats blockedSeats) throws Exception {
		return save(blockedSeats);
	}

	@Override
	public void deleteAll() {
		blockedSeatsRepository.deleteAll();
	}
	
	
}

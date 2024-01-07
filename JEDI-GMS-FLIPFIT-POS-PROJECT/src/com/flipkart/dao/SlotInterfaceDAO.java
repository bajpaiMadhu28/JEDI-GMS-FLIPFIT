package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public interface SlotInterfaceDAO {
    void addDummyDataSlot();

    ArrayList<Slot> getAllDummySlots();

    ArrayList<Slot> getDummyData(Integer centerId);

    boolean saveSlot(Slot slot);

    Integer getSlotId();

    Slot getSlotById(Integer slotId);

    ArrayList<Slot> getBookedSlotsByCustomerId(String customerId);

    void updateSlot(Slot slot);

    void deleteSlot(String slotId);

    List<Slot> getAvailableSlots(Integer centerId);

    boolean bookSlot(Booking booking);

    void updateWaitlist(String slotId, List<String> waitlist);

    void addSlot(Slot slot);

    boolean isSlotAlreadyExists(Slot slot);
}

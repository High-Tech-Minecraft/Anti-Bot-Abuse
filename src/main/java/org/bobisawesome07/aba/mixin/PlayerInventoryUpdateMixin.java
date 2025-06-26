package org.bobisawesome07.aba.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin (PlayerInventory.class)
public class PlayerInventoryUpdateMixin {
    @Shadow @Final public PlayerEntity player;

    @Inject(method = "setStack", at = @At("HEAD"))
    private void onSetStack(int slot, ItemStack stack, CallbackInfo ci) {
        PlayerInventory inventory = (PlayerInventory) (Object) this;
        ItemStack previousStack = inventory.getStack(slot);

        if (previousStack.isEmpty() && !stack.isEmpty()) {
            System.out.println("Item added to slot");
        } else if (!previousStack.isEmpty() && !stack.isEmpty() &&
                !ItemStack.areEqual(previousStack, stack)) {
            System.out.println("Slot changed");
        }
    }

    @Inject(method = "addStack(ILnet/minecraft/item/ItemStack;)I", at = @At("HEAD"))
    private void onAddStackToSlot(int slot, ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        if (!stack.isEmpty()) {

        }
    }

    @Inject(method = "insertStack(ILnet/minecraft/item/ItemStack;)Z", at = @At("HEAD"))
    private void onInsertStack(int slot, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!stack.isEmpty()) {

        }
    }

    @Inject(method = "offer", at = @At("HEAD"))
    private void onOffer(ItemStack stack, boolean notifiesClient, CallbackInfo ci) {
        if (!stack.isEmpty()) {

        }
    }

    private void inventoryEvent(int slot, ItemStack stack) {

    }
}

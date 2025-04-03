package com.yzf.mixin;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerGamePacketListenerImpl.class)
public class RemoveSpeedDetectionMixin {
    //将玩家常规移动速度检测值改为 Float 上限
    @ModifyConstant(method = "handleMovePlayer", constant = @Constant(floatValue = 100.0F))
    private float PlayerMaxSpeed(float speed) {
        return Float.MAX_VALUE;
    }

    //将玩家鞘翅飞行移动速度检测值改为 Float 上限
    @ModifyConstant(method = "handleMovePlayer", constant = @Constant(floatValue = 300.0F))
    private float ElytraMaxSpeed(float speed) {
        return Float.MAX_VALUE;
    }

    //将玩家载具移动速度检测值改为 Double 上限
    @ModifyConstant(method = "handleMoveVehicle", constant = @Constant(doubleValue = 100.0))
    private double VehicleMaxSpeed(double speed) {
        return Double.MAX_VALUE;
    }

    //将玩家移动错误检测值改为 Double 上限
    @ModifyConstant(method = "handleMovePlayer", constant = @Constant(doubleValue = 0.0625))
    private double MovedWrong(double speed) {
        return Double.MAX_VALUE;
    }

    //将玩家载具移动错误检测值改为 Double 上限
    @ModifyConstant(method = "handleMoveVehicle", constant = @Constant(doubleValue = 0.0625))
    private double VehicleMovedWrong(double speed) {
        return Double.MAX_VALUE;
    }
}

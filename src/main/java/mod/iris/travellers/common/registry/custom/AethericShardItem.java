package mod.iris.travellers.common.registry.custom;

import com.ibm.icu.text.MessagePattern;
import mod.maxbogomol.fluffy_fur.FluffyFurClient;
import mod.maxbogomol.fluffy_fur.client.particle.ParticleBuilder;
import mod.maxbogomol.fluffy_fur.client.particle.data.ColorParticleData;
import mod.maxbogomol.fluffy_fur.client.particle.data.ColorParticleDataBuilder;
import mod.maxbogomol.fluffy_fur.client.playerskin.FoxPlayerSkin;
import mod.maxbogomol.fluffy_fur.client.shader.postprocess.FluffyFurGlslPreprocessor;
import mod.maxbogomol.fluffy_fur.integration.client.ShadersIntegration;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurParticles;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurShaders;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DeathMessageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.awt.*;

public class AethericShardItem extends Item {


    public AethericShardItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();

        player.hurtMarked = true;





        ParticleBuilder.create(FluffyFurParticles.STAR).setColorData(ColorParticleData.create(Color.YELLOW).build()).setForce(true).randomOffset(5).repeat(pContext.getLevel(),pContext.getPlayer().position(),200).setLifetime(8000);
        player.moveTo(player.position().add(0,20,0));
        ParticleBuilder.create(FluffyFurParticles.SUN).setLifetime(99999999).setForce(true).spawn(level,player.position());
        player.moveTo(player.getX(),player.getY()-1,player.getZ());

        ParticleBuilder.create(FluffyFurParticles.DOT).spawn(level,player.position());

        player.kill();


        return InteractionResult.SUCCESS;
    }


}

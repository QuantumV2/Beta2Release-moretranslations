package com.github.dirtpowered.betatorelease.network.handler.connection;

import com.github.dirtpowered.betaprotocollib.packet.Version_B1_7.data.UpdateSignPacketData;
import com.github.dirtpowered.betatorelease.network.handler.BetaToModernHandler;
import com.github.dirtpowered.betatorelease.network.session.Session;
import com.github.steveice10.mc.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.protocol.packet.ingame.client.world.ClientUpdateSignPacket;

public class UpdateSignPacketHandler implements BetaToModernHandler<UpdateSignPacketData> {

    @Override
    public void handlePacket(Session session, UpdateSignPacketData packetClass) {
        int x = packetClass.getX();
        int y = packetClass.getY();
        int z = packetClass.getZ();

        String[] lines = packetClass.getSignLines();
        Position position = new Position(x, y, z);

        // FIXME: updates the sign, but still no text is displayed
        session.getModernClient().sendModernPacket(new ClientUpdateSignPacket(position, lines));
    }
}